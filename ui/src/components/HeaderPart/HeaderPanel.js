/**
 * Created by Denis on 29.04.2018.
 */
import React, {Component} from "react"
import {Button, Checkbox, Icon, Switch} from "antd";
import LoginDetails from "./LoginDetails";
import UserDetails from "./UserDetails";
import propTypes from "prop-types"

export default class HeaderPanel extends Component {
    render() {
        const {
            onMenuClick, onTitleClick, titleImage, isAuthenticated, userName, userImage,
            detailsStyle, headerPanelStyle, menuButtonStyle, menuIconStyle,
            menuIconFold, menuIconUnFold, titleContainerStyle, titleStyle,
            titleWidth, titleHeight, logoutButtonStyle, logoutOnClick, logoutText,
            menuVisible, liteMode, liteModeChanged
        } = this.props;
        return <div
            style={headerPanelStyle}
        >
            <Button type="primary" onClick={onMenuClick} style={menuButtonStyle}>
                <Icon style={menuIconStyle}
                      type={menuVisible ? menuIconFold : menuIconUnFold}/>
            </Button>
            <div style={titleContainerStyle} onClick={onTitleClick}>
                <img width={titleWidth} height={titleHeight} style={titleStyle} src={titleImage}/>
            </div>
            <div style={detailsStyle}>
                <Switch
                    style={{marginRight: "10px"}}
                    checkedChildren="hard"
                    unCheckedChildren="lite"
                    checked={liteMode}
                    onChange={() => liteModeChanged(!liteMode)}
                />
                {
                    isAuthenticated
                        ?
                        <div style={{display:"flex"}}>
                            <UserDetails name={userName} avatar={userImage}/>
                            <button style={{height: "30%", alignSelf: "center"}} className={logoutButtonStyle} onClick={logoutOnClick}>
                                {logoutText}
                            </button>
                        </div>
                        :
                        <div>
                            <LoginDetails/>
                        </div>
                }
            </div>
        </div>
    }
}

HeaderPanel.propTypes = {
    detailsStyle: propTypes.object.isRequired,
    headerPanelStyle: propTypes.object.isRequired,
    isAuthenticated: propTypes.bool.isRequired,
    logoutButtonStyle: propTypes.string.isRequired,
    logoutOnClick: propTypes.func.isRequired,
    logoutText: propTypes.string.isRequired,
    menuButtonStyle: propTypes.object.isRequired,
    menuIconStyle: propTypes.object.isRequired,
    menuIconFold: propTypes.string.isRequired,
    menuIconUnFold: propTypes.string.isRequired,
    menuVisible: propTypes.bool.isRequired,
    onMenuClick: propTypes.func.isRequired,
    onTitleClick: propTypes.func.isRequired,
    titleImage: propTypes.string,
    titleContainerStyle: propTypes.object.isRequired,
    titleHeight: propTypes.object.isRequired,
    titleStyle: propTypes.object.isRequired,
    titleWidth: propTypes.string.isRequired,
    userImage: propTypes.string,
    userName: propTypes.string.isRequired,
    liteMode: propTypes.bool.isRequired,
    liteModeChanged: propTypes.func.isRequired,
};

HeaderPanel.defaultProps = {
    detailsStyle: {
        margin: "0px 20px 0px auto",
        display: "flex",
        alignItems: "center"
    },
    headerPanelStyle: {},
    isAuthenticated: false,
    logoutOnClick: () => {
    },
    logoutText: "Logout",
    menuButtonStyle: {},
    menuIconStyle: {},
    menuIconFold: 'menu-fold',
    menuIconUnfold: 'menu-unfold',
    menuVisible: false,
    titleContainerStyle: {},
    titleHeight: "86px",
    titleStyle: {},
    titleWidth: "180px",
    onMenuClick: () => {
    },
    onTitleClick: () => {
    },
    userName: "Guest",
};