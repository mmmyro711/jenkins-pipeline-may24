terraform {
  backend "s3" {
    bucket = "terraform-session-jan-backend-myroslav" # backend s3 bucket name
    key    = "class/may24/jenkins/classwork/session4/server.tfstate"     # backend path and file name
    region = "us-east-1"
  }
}