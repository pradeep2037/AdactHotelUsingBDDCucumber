pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    stages {

        stage('Run Automation Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        always {

            junit testResults: 'target/cucumber-reports/cucumber.xml',
                  allowEmptyResults: true

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