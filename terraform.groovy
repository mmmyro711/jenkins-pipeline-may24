pipeline{
    agent any 
    stages {

    parameters {
        choice(name: 'TF_ACTION', choices: ['apply', 'destroy'], description: 'select the action')

    }    
        stage('init'){
            steps{
                dir('infra'){
                    sh 'terraform init'
                    sh 'terraform validate'
                    sh 'terraform fmt'
                }             
            }
        }
        stage('plan'){    
            steps{
                dir('infra'){
                    sh 'terraform plan'
                } 
            }
        }
{
 
        stage('apply'){
            steps{
                 dir('infra'){
                    sh "terraform ${env.TF_ACTION} --auto-approve"
                }  
            }  
        }
    }
    post {
        success {
            echo 'This will run if the pipeline succeeds.'
        }
        failure {
            echo 'This will run if the pipeline fails.'
        }
    }
    }
}