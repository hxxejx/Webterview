<template>
  <div v-if="type==='applicant'">
    <div v-if="isWaiting">
      <header>
      <h1>
        <a href="#" class="logo"
          ><img src="@/../public/resources/images/logo.png" width="240"
        /></a>
      </h1>
    </header>
    <div id="camera-check" style="margin: 5%">
      <camera :resolution="{ width: 600, height: 400 }" autoplay></camera>
      <div>
        <h3>💻 화면/음성상태 체크</h3>
        <br /><br />
        <div v-if="!admission">
          <div>👤 잠시만 기다려 주세요</div>

          <div
            class="btn"
            style="background-color: #f5f5f5; color: #777777"
            @click="enterInterview"
          >
            승인 대기 중
          </div>
        </div>
        <div v-if="admission">
          <div>👤 입장해 주세요</div>
          <button
            type="button"
            class="btn"
            @click="isWaiting = false"
            style="background-color: #f05454; color: white"
          >
            입장하기
          </button>
        </div>
      </div>
    </div>
    </div>
    <div v-if="!isWaiting">
      <a-temp-screen></a-temp-screen>
    </div>
  </div>
  <div v-if="type==='rater'">
    <r-temp-screen></r-temp-screen>
  </div>
</template>

<script>
import ATempScreen from "@/components/interview/ATempScreen.vue";
import RTempScreen from "@/components/interview/RTempScreen.vue";
// import WaitingRoom from "@/components/interview/WaitingRoom.vue";
import { mapGetters } from "vuex";
import Camera from "simple-vue-camera";

export default {
  name: "InterviewView",
  components: { ATempScreen, RTempScreen, Camera },
  data() {
    return {
      isWaiting: true,
      type: undefined,
      admission: true,
    };
  },
  mounted() {
    this.type = this.$route.params.type;
  },
  computed: {
    ...mapGetters(["newApplicant"]),
    call() {
      console.log(this.$store);
      return this.$store.getters["infochecks/newApplicant"];
    },
  },
  watch: {
    newApplicant(no) {
      if (no === this.$route.params.applicantNo) {
        this.admission = true;
      }
      console.log(no);
    },
  },
  methods: {
    enterInterview() {
      console.log(this.newApplicant);
      console.log(this.$route.params.applicantNo);
      if (this.newApplicant === this.$route.params.applicantNo) {
        this.admission = true;
      }
    },
  },

};
</script>

<style>
#camera-check {
  background-color: #ffffff;
  padding: 3rem;
  border-radius: 1rem;
  display: flex;
  grid-gap: 1%;
  justify-items: center;
  align-items: center;
}

#camera-check div {
  flex: 1 !important;
}

header {
  width: 100%;
  text-align: center;
  position: relative;
  height: 80px;
  box-shadow: 0 5px 10px 10px #e5e5e5;
  background-color: #fff;
  vertical-align: center;
}
/* header h1 {
  position: absolute;
  top: 5px;
  left: 50%;
} */
</style>
