pipeline {
  agent {
    docker {
      image 'nodejs-aws'
    }

  }
  stages {
    stage('Build & Deploy Dev Environment') {
      environment {
        APPNAME = "test"
        ENVNAME = "test-dev"
        STATE = "dev"
        S3BUCKET = "glue-terraform"
        S3KEYPREFIX = "testprefix"
        REGION = "ap-southeast-1"
      }
      steps {
        //account AWS use to test plan
        withAWS(credentials: 'jenkins-test', region: 'ap-southeast-1') {
          deployEBNodeJS(EB_APP_NAME: 'test', EB_ENV_NAME: 'test-dev', state: 'dev', s3Bucket: 'glue-terraform', s3KeyPrefix: 'testprefix', REGION: 'ap-southeast-1')
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