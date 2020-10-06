pipeline{
 agent any
    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven-3') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven-3') {
                    bat 'mvn test'
                }
            }
        }
  
   }
 }

