pipeline {
    agent any
    parameters {
        string(name: 'BROWSER', defaultValue: 'chrome', description: 'Browser to use for tests')
    }
    stages {
        stage('Checkout') {
            steps {
                // Clone the repository
                git 'git@github.com:trclinton/Company.git'
            }
        }
        stage('Build') {
            steps {
                // Build the project using Gradle
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                script {
                    // Run the tests with the browser parameter
                    sh "./gradlew test -Dbrowser=${params.BROWSER}"
                }
            }
        }
    }
    post {
        always {
            // Archive test results and clean up
            junit 'build/test-results/test/*.xml'
            cleanWs()
        }
    }
}
