pipeline {
    agent any
    stages {
        stage('Check') {
            steps {
            sshagent(credentials: ['ansible_user']) {
                    sh 'pwd'
                    sh 'ls -la'
                    sh 'ansible-playbook -i hosts playbook2.yml'
                }
            }
        }
    }
}