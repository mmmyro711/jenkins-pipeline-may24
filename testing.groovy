pipeline {
    agent any
    stages {
        stage('Echo Environment Variables') {
            steps {
                echo "Current build number: ${env.BUILD_NUMBER}"
                echo "The name of the job is: ${env.JOB_NAME}"
                echo "The workspace path is: ${env.WORKSPACE}"
            }
        }
    }
}