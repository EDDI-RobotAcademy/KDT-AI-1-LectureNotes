import React, {useEffect, useRef, useState} from "react";
import ReactDOM from 'react-dom'
import EventBus from 'event-bus';
import mitt from "mitt";
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import Home from "./router/containerApp/Home";
import VueEventBusRemoteApp from "./router/vueEventBusTestApp/VueEventBusRemoteApp";
import {Button} from "@mui/material";
import VueEventInstantRemoteApp from "./router/vueEventBusTestApp/VueEventInstantRemoteApp";
import VueModuleAppRouter from "./router/vueModuleApp/VueModuleAppRouter";
import VueNavigationBarApp from "./router/vueNavigationApp/VueNavigationBarApp";
import VueCounterContainerRemoteApp from "./router/vueCounterContainerApp/VueCounterContainerRemoteApp";

const eventBus = mitt();

const withSingleInstance = (Component) => {
    let instance = null;

    return (props) => {
        if (!instance) {
            instance = <Component {...props} />;
        }

        return instance;
    };
};

const App = () => {
    // const [message, setMessage] = useState('');
    // const vueModuleRef = useRef(null);
    // const isMountedRef = useRef(false); // 마운트 여부를 저장하는 변수
    //
    // const handleOtherButtonClick = async () => {
    //     setMessage('클릭했음');
    //     eventBus.emit('dataReceived', 'Hello from React Container App!');
    // };
    //
    // useEffect(() => {
    //     const mountVueComponent = async () => {
    //         const { mount } = await import('vueEventBusTestApp/VueRemotesApp');
    //         mount(vueModuleRef.current, eventBus);
    //     };
    //
    //     mountVueComponent();
    // }, []);

    return (
        <BrowserRouter>
            <VueNavigationBarApp/>
            <div>
                <h1>React Container App</h1>
                <Button component={Link} to="/" variant="contained">
                    홈
                </Button>
                <Button component={Link} to="/vue-event-bus-test" variant="contained">
                    Vue Event Bus
                </Button>
                <Button component={Link} to="/event-instant" variant="contained">
                    즉시 반응(Event Bus)
                </Button>
                <Button component={Link} to="/event-instant" variant="contained">
                    즉시 반응(Event Bus)
                </Button>
                <Button component={Link} to="/vue-board-app" variant="contained">
                    Vue 게시판
                </Button>
                <Button component={Link} to="/vue-counter-container-app" variant="contained">
                    Vue remotes in Vue remotes
                </Button>
                <Routes>
                    <Route exact path="/" element={<Home/>} />
                    <Route exact path="/vue-event-bus-test" element={<VueEventBusRemoteApp/>} />
                    <Route exact path="/event-instant" element={<VueEventInstantRemoteApp/>} />
                    <Route exact path="/vue-board-app/*" element={<VueModuleAppRouter/>} />
                    <Route exact path="/vue-counter-container-app" element={<VueCounterContainerRemoteApp/>} />
                </Routes>
            </div>
        </BrowserRouter>
    );
};

export default App;



