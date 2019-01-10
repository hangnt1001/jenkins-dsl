pipeline {
  agent {
    docker {
      image 'nodejs-aws'
    }

  }
  parameters {
        choice(name: 'ENV_NAME', choices: ['dev','qa','staging'], description: 'Select environment to import data')
        choice(name: 'SCHEMA_NAME', choices: ['test.json','test2.json'], description: 'Select schema file used to import')
  }
  environment {
      USER_ID = '5EE0E3C-146Z-7646-CCEE-A0EDX2760869'
      REPOS = '/home/test'
      gitCredentialsId = 'aiman-bitbucket'
  }
  stages {
    stage('Deploy EB NodeJS') {
      when {
        branch 'master'
      }
      steps {
        importDataToAPI(ENV_NAME: "${params.ENV_NAME}",SCHEMA_NAME: "${params.SCHEMA_NAME}")
      }
    }
  }
}