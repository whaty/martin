pipeline {
  agent any
  stages {
    stage('echo') {
      agent {
        docker {
          image 'maven:3-alpine'
        }

      }
      steps {
        sh 'echo \'123\''
      }
    }

  }
}