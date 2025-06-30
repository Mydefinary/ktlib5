<template>
    <div>
        <Number
            label="pointId"
            v-model="value.pointId"
            :editMode="editMode"
        />
        <Number
            label="PointBalance"
            v-model="value.pointBalance"
            :editMode="editMode"
        />
        <Date
            label="PointRechargeDate"
            v-model="value.pointRechargeDate"
            :editMode="editMode"
        />
        <Date
            label="PointSpendDate"
            v-model="value.pointSpendDate"
            :editMode="editMode"
        />
        <Number
            label="UserId"
            v-model="value.userId"
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
    name: 'Point',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "points",
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
