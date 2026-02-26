pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Lalit-QA/CucumberFinalGitPractice1.git'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            publishHTML([
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/cucumber-report',
                reportFiles: 'cucumber2.html',
                reportName: 'Cucumber HTML Report'
            ])
        }
    }
}