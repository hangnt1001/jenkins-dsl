pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        timeout(time: 10, activity: true, unit: 'MINUTES') {
          retry(count: 10) {
            sh '''if (STATUS == "Ready"){
                    echo "Status is ${STATUS}, proceeding to deployment"
                    break;
                }'''
            }

          }

          sleep(time: 1, unit: 'MINUTES')
          timeout(time: 25, activity: true, unit: 'MINUTES') {
            retry(count: 25) {
              sh 'echo "retry"'
            }

          }

        }
      }
    }
  }