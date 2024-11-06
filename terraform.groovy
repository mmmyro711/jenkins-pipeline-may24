ppeline {
    agent any
    stages{
        stage('terraform-init'){
            steps{
                sh 'terraform init'
            }
        }
        stage('terraform-validate'){
            steps{
                sh 'terraform validate'
            }
        }
        stage('fmt'){
            steps {
                sh 'terraform fmt'
            }
        }
        stage('plan'){
            steps{
                sh 'terraform plan'
            }
        }
        stage('apply'){
            steps{
                sh 'terraform apply --auto-approve'
            }
        }
        
    }
}