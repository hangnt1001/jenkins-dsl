pipeline {
  agent any
  stages {
    stage('build') {
      withAWS(credentials: ‘jenkins-test’, region: ‘ap-southeast-1’) {
          deployEBNodeJS('test', 'test-dev', 'dev', 'glue-terraform', 'testprefix', 'ap-southeast-1')
        }
    }
  }