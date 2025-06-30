<template>
    <div>
        <Number
            label="PublicationId"
            v-model="value.publicationId"
            :editMode="editMode"
        />
        <Number
            label="manuscriptId"
            v-model="value.manuscriptId"
            :editMode="editMode"
        />
        <Date
            label="PublicationDate"
            v-model="value.publicationDate"
            :editMode="editMode"
        />
        <String
            label="CoverUrl"
            v-model="value.coverUrl"
            :editMode="editMode"
        />
        <String
            label="Genre"
            v-model="value.genre"
            :editMode="editMode"
        />
        <String
            label="Summary"
            v-model="value.summary"
            :editMode="editMode"
        />
        <Number
            label="ReadCost"
            v-model="value.readCost"
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
    name: 'Publish',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "publishes",
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
