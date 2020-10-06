pipeline{
 agent any
    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven-3') {
                 echo "::::in compile stage"
                    bat 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                echo "::::in test stage"
                withMaven(maven : 'maven-3') {
                    bat 'mvn test'
                }
            }
        }
  
   }
 }

