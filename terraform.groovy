pipeline{
    agent any 
    
    parameters {
    choice(name: 'TF_ACTION', choices: ['apply', 'destroy'], description: 'select the action')
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
        stage('choice') {
            steps {
                script {
                    echo "action selected: ${params.TF_ACTION}"
                }
            }
        }
        stage('apply'){
            steps{
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