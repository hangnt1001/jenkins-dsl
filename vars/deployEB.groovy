def call(String environment, String appName, String s3Bucket, String awsDefaultRegion = 'us-east-1') {
  // environment of null means dev
  environment = environment ?: 'dev'
  // appName of null means test
  appName = appName ?: 'test'
  // environment name
  def environmentName = "${environment}-${appName}"
  // s3Bucket of null means test-builds
  s3Bucket = s3Bucket ?: 'test-builds'
  // awsDefaultRegion of null means us-east-1
  awsDefaultRegion = awsDefaultRegion ?: 'us-east-1' 
  appVersion = sh (
      script: 'git rev-parse --short HEAD',
      returnStdout: true
  ).trim()
  // clean git
  sh "git clean -fd"
  // zip package
  sh "zip -x *.git* -r '${appName}-${appVersion}.zip'"
  
  if (environment == 'dev' || environment == "staging" || environment == "production") {
      sh "aws elasticbeanstalk delete-application-version --application-name ${appName} --version-label ${appVersion}  --delete-source-bundle"
      sh "aws s3 cp ${appName}-${appVersion}.zip s3://${s3Bucket}/${appName}-${appVersion}.zip"
      sleep 10
      sh "aws elasticbeanstalk create-application-version --application-name ${appName} --version-label ${appVersion} --source-bundle S3Bucket=${s3Bucket},S3Key=${appName}-${appVersion}.zip"
      sh "aws elasticbeanstalk update-environment --environment-name ${environmentName} --version-label ${appVersion}"

  } else {
      sh "echo 'Wrong Environment to push'"
  }

}