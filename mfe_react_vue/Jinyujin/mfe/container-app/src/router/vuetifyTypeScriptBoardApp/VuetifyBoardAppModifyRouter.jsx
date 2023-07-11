import React, { useEffect, useRef } from 'react'

const VuetifyBoardAppModifyRouter = () => {
    const vuetifyBoardModifyRef = useRef(null)

    useEffect(() => {
        const loadRemoteComponent = async () => {
            const { modifyBootstrapMount } = await import('vuetifyTailwindBoardApp/boardModifyBootstrap')
            modifyBootstrapMount(vuetifyBoardModifyRef.current)
        }

        loadRemoteComponent()
    }, [vuetifyBoardModifyRef])

    return (
        <div>
            <div>
                <div style={{ position: 'relative' }} ref={vuetifyBoardModifyRef} />
            </div>
        </div>
    )
}

export default VuetifyBoardAppModifyRouter