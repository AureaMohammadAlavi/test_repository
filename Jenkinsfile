pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                gradlew('clean', 'classes')
            }
        }
        stage('Assemble') {
            steps {
                gradlew('assemble')
            }
        }
        stage('Publish to Bintray') {
            environment {
               BINTRAY_API_KEY=credentials('BINTRAY_API_KEY')
               GPG_SIGNING_PASSWORD=credentials('GPG_SIGNING_PASSWORD')
            }
            steps {
                gradlew('publishMyPublicationPublicationToBintaryRepository')
            }
        }
    }
}

def gradlew(String... args) {
    sh "./gradlew ${args.join(' ')} -s"
}