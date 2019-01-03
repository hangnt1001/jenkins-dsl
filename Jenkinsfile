pipeline {
  agent {
    docker {
      image 'nodejs-aws'
    }

  }
  stages {
    stage('Build') {
      steps {
        //account AWS use to test plan
        withAWS(credentials: 'jenkins-test', region: 'ap-southeast-1') {
          deployEBNodeJS('test', 'test-dev', 'dev', 'glue-terraform', 'testprefix', 'ap-southeast-1')
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