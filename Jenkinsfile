pipeline {
  agent {
    docker {
      image 'nodejs-aws'
    }

  }
  parameters {
      choice(name: 'ENV_NAME', choices: ENVS, description: 'Select environment to import data')
      choice(name: 'SCHEMA_NAME', choices: SCHEMA_NAME, description: 'Select schema file used to import')
  }
  environment {
      USER_ID = '5EE0E3C-146Z-7646-CCEE-A0EDX2760869'
      REPOS = '/home/test'
      ENVS = "['dev','qa','staging']"
      SCHEMA_NAME = "['test.json','test2.json']"
  }
  stages {
    stage('Deploy EB NodeJS') {
      when {
        branch 'master'
      }
      parallel {
        stage('Deploy google-develop'){
          steps {
            //deploy google-develop
            withAWS(credentials: 'jenkins-test', region: 'ap-southeast-1') {
              deployEBNodeJS(EB_APP_NAME: 'google-develop', EB_ENV_NAME: 'google-dev', state: 'dev', s3Bucket: 'glue-terraform', s3KeyPrefix: 'googleprefix', REGION: 'ap-southeast-1')
            }
          }
        }
        stage('Deploy yahoo-develop'){
          steps {
            //deploy yahoo-develop
            withAWS(credentials: 'jenkins-test', region: 'ap-southeast-1') {
              deployEBNodeJS(EB_APP_NAME: 'yahoo-develop', EB_ENV_NAME: 'yahoo-dev', state: 'dev', s3Bucket: 'glue-terraform', s3KeyPrefix: 'yahooprefix', REGION: 'ap-southeast-1')
            }
          }
        }
        stage('Deploy apple-develop'){
          steps {
             //deploy apple-develop
              withAWS(credentials: 'jenkins-test', region: 'ap-southeast-1') {
                deployEBNodeJS(EB_APP_NAME: 'apple-develop', EB_ENV_NAME: 'apple-dev', state: 'dev', s3Bucket: 'glue-terraform', s3KeyPrefix: 'appleprefix', REGION: 'ap-southeast-1')
              }
          }
        }
      }
    }
  }
}