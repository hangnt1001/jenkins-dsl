pipeline {
  agent {
    docker {
      image 'nodejs-aws'
    }

  }
  stages {
    stage('Build & Deploy Dev Environment') {
      steps {
        //account AWS use to test plan
        APPNAME = "test"
        ENVNAME = "test-dev"
        STATE = "dev"
        S3BUCKET = "glue-terraform"
        S3KEYPREFIX = "testprefix"
        REGION = "ap-southeast-1"
        withAWS(credentials: 'jenkins-test', region: 'ap-southeast-1') {
          deployEBNodeJS(APPNAME, ENVNAME, STATE, S3BUCKET, S3KEYPREFIX, REGION)
        }
      }
    }
     stage('Build & Deploy QA Environment') {
      steps {
        //account AWS use to test plan
        APPNAME = "test"
        ENVNAME = "test-qa"
        STATE = "qa"
        S3BUCKET = "glue-terraform"
        S3KEYPREFIX = "testprefix"
        REGION = "ap-southeast-1"
        withAWS(credentials: 'jenkins-test', region: 'ap-southeast-1') {
          deployEBNodeJS(APPNAME, ENVNAME, STATE, S3BUCKET, S3KEYPREFIX, REGION)
        }
      }
    }
  }
  post {
    always {
      //sendNotification(currentBuild.result)
      echo "test"
    }
  }
  environment {
    ORG = 'ibexlabs'
  }
}