pipeline {
    agent any
    parameters {
        string(name: 'BROWSER', defaultValue: 'chrome', description: 'Browser to use for tests')
    }
    stages {
        stage('Build') {
            steps {
                // Your build steps here
            }
        }
        stage('Test') {
            steps {
                script {
                    // Run your tests with the browser parameter
                    sh "mvn test -Dbrowser=${params.BROWSER}"
                }
            }
        }
    }
}
