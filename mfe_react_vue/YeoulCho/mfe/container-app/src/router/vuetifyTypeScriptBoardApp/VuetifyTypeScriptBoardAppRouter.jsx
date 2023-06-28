import React, { useEffect } from 'react'

const VuetifyTypeScriptBoardAppRouter = ({ vuetifyTypeScriptBoardRef, naviHeight}) => {
    useEffect(()=>{
        const loadRemoteComponent = async () =>{
            const {vuetifyTypeScriptBoardAppMount} =await import('vuetifyTailwindBoardApp/vuetifyBoardBootstrap')
            vuetifyTypeScriptBoardAppMount(vuetifyTypeScriptBoardRef.current)
        }

        loadRemoteComponent()
    },[vuetifyTypeScriptBoardRef])
  return (

    <div>
        <div>
            <div ref={vuetifyTypeScriptBoardRef}></div>
        </div>
    </div>
  )
}

export default VuetifyTypeScriptBoardAppRouter