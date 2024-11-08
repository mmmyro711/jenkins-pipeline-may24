pipeline {
    agent any
    stages {
        stage('Deploy') {
            steps {
                echo "build number: ${env.BUILD_NUMBER}"
                echo "name of the job: ${env.JOB_NAME}"
                echo "the workspace: ${env.WORKSPACE}"
            }
        }
    }
}