pipeline {
    agent any
    environment {
        cred = credentials('path')
    }
    stages {
        stage('Check') {
            steps {
            sshagent(credentials: ['ansible_user']) {
                    sh 'pwd'
                    sh 'ls -la'
                    sh 'ansible-playbook -i hosts playbook.yml --extra-vars "ansible_sudo_pass=${cred}"'
                }
            }
        }
    }
}