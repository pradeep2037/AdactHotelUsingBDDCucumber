pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Automation Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        always {
            junit allowEmptyResults: true,
                  testResults: 'target/cucumber-reports/cucumber.xml'

            archiveArtifacts artifacts: 'target/cucumber-reports/**/*',
                             allowEmptyArchive: true

            archiveArtifacts artifacts: 'target/screenshots/**/*',
                             allowEmptyArchive: true
        }

        success {
            echo 'AdactIn Automation Tests PASSED'
        }

        failure {
            echo 'AdactIn Automation Tests FAILED'
        }
    }
}