terraform {
    required_version = ">=1.7.4, <=1.9.8"     // Terraform Version
    required_providers {     // Provider Version
      aws = {
        source = "hashicorp/aws"
        version = "~> 5.49.0"
      }
    }
}
