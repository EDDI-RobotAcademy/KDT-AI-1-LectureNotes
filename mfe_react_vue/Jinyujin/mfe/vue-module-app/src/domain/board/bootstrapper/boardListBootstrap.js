import { mount } from "../../../bootstrap"
import router from "../../../router"

const listBootstrapMount = (el) => {
    const vueBoardApp = mount(el)

    const newRoute = {
        name: 'BoardListPage',
    }

    router.push(newRoute)
}

export { listBootstrapMount }