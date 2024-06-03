pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven 'maven-3'
    }
    stages {

        stage('-verify briwsers are installed') {
            steps {
                sh 'google-chrome --version'
            }
        }
        stage('Run Test') {
            steps {
                sh './mvnw clean test'
            }    
        }
    }
}
