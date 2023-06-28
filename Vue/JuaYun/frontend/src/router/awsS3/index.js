import Vue from 'vue'
import VueRouter from 'vue-router'

import AwsS3 from '@/views/awsS3/AwsS3.vue'

Vue.use(VueRouter)

const awsS3Routes = [
    {
        path: '/aws-s3',
        name: 'AwsS3',
        component: AwsS3
    },
]

export default awsS3Routes