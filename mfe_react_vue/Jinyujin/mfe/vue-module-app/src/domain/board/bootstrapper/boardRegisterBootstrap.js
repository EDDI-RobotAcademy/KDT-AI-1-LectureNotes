import {mount} from "../../../bootstrap"
import router from "../../../router"

const registerBootstrapMount = (el) => {
    const vueBoardApp = mount(el)

    const newRoute = {
        name: 'BoardRegisterPage',
    }

    router.push(newRoute)
}

export {registerBootstrapMount}