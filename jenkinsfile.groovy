node{
    properties([parameters([string(defaultValue: 'IP', description: 'where to build  IP', name: 'Env', trim: false)])])
    stage("Clone repo"){
        git 'https://github.com/ainsfa20182018/python-flask.git'
    }
    stage("Build application"){
        sh "scp -r * ec2-user@${ENV}:/tmp"
        sh "ssh ec2-user@${ENV} pip install -r /tmp/requirements.txt"
    }
     stage("App Run"){
        sh "ssh ec2-user@${ENV}  python  /tmp/app.py"
    }
}