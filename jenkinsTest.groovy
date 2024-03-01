pipeline {
    agent any

    stages {
        stage('Fetch Code from Github') {
            steps {

                git branch: 'main', credentialsId: '002238ce-8e84-477d-a753-de49750df675', url: 'https://github.com/anantkumarbadal/Automation_Framework_E-Commerce.git'
                echo 'Fetching code from GitHub'
            }
        }

        stage('Build Code') {
            steps {
                // Add your build commands here
                bat script: 'mvn compile'
            }
        }

        stage('Run Tests') {
            steps {
                // Add your test execution commands here

                bat script: 'mvn test'
            }
        }

        stage('Publish Extent Report') {
            steps {
                // Publish Extent HTML report
                publishHTML(target: [
                        allowMissing         : false,
                        alwaysLinkToLastBuild: true,
                        keepAll              : true,
                        reportDir            : 'target/surefire-reports',
                        reportFiles          : 'extent-report.html',
                        reportName           : 'Pipeline-Extent Report'
                ])
            }
        }
    }
}
