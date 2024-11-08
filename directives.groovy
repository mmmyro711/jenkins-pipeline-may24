pipeline {
    agent any 
    environment {
        Var1 = "building"
        Var2 = "testing"
        Var3 = "success"
    }
    parameters {
        string(name: 'USER', description: 'Who is running Jenkins pipeline?', defaultValue: 'myro' )
    }
    stages {
        stage('build') {
            steps {
                echo " This is ${Var1}"
            }
        }
        stage('Test'){
            steps{
                echo "This is ${env.Var2}"
                echo "${params.USER} is running the job"
            }
        }
        stage('Deploy') {
            steps {
                echo "build number: ${env.BUILD_NUMBER}"
                echo "name of the job: ${env.JOB_NAME}"
                echo "the workspace: ${env.WORKSPACE}"
                echo "the build tag: ${env.JOB_NAME}-${env.BUILD_NUMBER}"
                echo "job url: $job_url"
                echo "job url: $JOB_URL"
                echo "job url: ${BUILD_ID}"


            }
        }
    }
}