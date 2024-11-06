pipeline{
    agent any 
    stages {
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
        stage('apply'){
            steps{
                 dir('infra'){
                    sh 'terraform apply --auto-approve'
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