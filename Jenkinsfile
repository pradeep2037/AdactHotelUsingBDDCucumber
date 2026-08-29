pipeline {

    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    stages {

        stage('Run Automation Tests') {

            steps {
                bat 'mvn clean test -Dheadless=true'
            }
        }
    }

    post {

        always {

            junit testResults: 'target/cucumber-reports/cucumber.xml',
                  allowEmptyResults: true

            publishHTML(target: [
                reportDir: 'target/cucumber-reports',
                reportFiles: 'cucumber-report.html',
                reportName: 'Cucumber HTML Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: false
            ])

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