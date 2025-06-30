<template>
    <div>
        <Number
            label="BookId"
            v-model="value.bookId"
            :editMode="editMode"
        />
        <Date
            label="RegistrationDate"
            v-model="value.registrationDate"
            :editMode="editMode"
        />
        <Date
            label="PublicationDate"
            v-model="value.publicationDate"
            :editMode="editMode"
        />
        <Number
            label="NumberOfSubscribers"
            v-model="value.numberOfSubscribers"
            :editMode="editMode"
        />
        <Number
            label="publicationId"
            v-model="value.publicationId"
            :editMode="editMode"
        />
        <Number
            label="manuscriptId"
            v-model="value.manuscriptId"
            :editMode="editMode"
        />
        <Number
            label="authorId"
            v-model="value.authorId"
            :editMode="editMode"
        />
        <String
            label="Status"
            v-model="value.status"
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
    name: 'Book',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "books",
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
