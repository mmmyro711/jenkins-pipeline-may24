pipeline{
    agent any 
    
    parameters {
    choice(name: 'TF_ACTION', choices: ['apply', 'destroy'], description: 'select the action')
    }
    options { 
      buildDiscarder(logRotator(numToKeepStr: '3'))
      timeout(time: 4, unit: 'MINUTES')
    }
      
    stages {
   
        stage('init'){
            steps{
                dir('infra'){
                    sh 'terraform init -migrate-state'
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
                input message: 'Do you want to approve the deployment?', ok: 'Yes'
                dir('infra'){
                    sh "terraform ${params.TF_ACTION} --auto-approve"
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