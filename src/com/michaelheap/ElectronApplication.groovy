#!/usr/bin/env groovy

package com.michaelheap;

def execute() {
    node {
        checkout scm
        sh 'npm install'
        sh 'npm test'
        sh 'npm run lint'
        sh 'npm run build-linux'
        dir('dist') {
            archiveArtifacts artifacts: '*.Appimage', fingerprint: true;
        }
    }
}

return this;
