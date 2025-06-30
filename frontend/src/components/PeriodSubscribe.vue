<template>
    <div>
        <Number
            label="RecurringSubscriptionId"
            v-model="value.recurringSubscriptionId"
            :editMode="editMode"
        />
        <Number
            label="userId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <Date
            label="StartedAt"
            v-model="value.startedAt"
            :editMode="editMode"
        />
        <Date
            label="NextPaymentDue"
            v-model="value.nextPaymentDue"
            :editMode="editMode"
        />
        <Boolean
            label="IsActive"
            v-model="value.isActive"
            :editMode="editMode"
        />
        <Date
            label="LastPaymentAt"
            v-model="value.lastPaymentAt"
            :editMode="editMode"
        />
        <Boolean
            label="AccessGranted"
            v-model="value.accessGranted"
            :editMode="editMode"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'PeriodSubscribe',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "periodSubscribes",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
