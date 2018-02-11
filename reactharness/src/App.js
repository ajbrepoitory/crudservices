import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import './w3-theme-black.css';
import './css.css';
//import './font-awesome.min.css';
import './w3.css';

var divStyle = {
  marginLeft: "200px"
};
class App extends Component {
  render() {
    return (
        <MasterHarness/>
    );
  }
}
class MasterHarness extends Component{
  render(){
    return(
          <div>
                  <HeaderPane/>
                  <LeftPane/>
                  <OverLay/>
                  <MainPane/>
                  <Footer/>
          </div>
    );
  }
}
class HeaderPane extends Component{
  render(){
    return(
      //Top Navigation Bar
      <div class="w3-top">
        <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
          <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars">Menu</i></a>
          <a  class="w3-bar-item w3-button w3-theme-l1">Logo</a>
          <a  class="w3-bar-item w3-button w3-hide-small w3-hover-white">About</a>
          <a  class="w3-bar-item w3-button w3-hide-small w3-hover-white">Values</a>
          <a  class="w3-bar-item w3-button w3-hide-small w3-hover-white">News</a>
          <a  class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contact</a>
          <a  class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Clients</a>
          <a  class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Partners</a>
        </div>
      </div>

    );
  }
}

class LeftPane extends Component{
  render(){
    return(
      //-- Sidebar --
      <nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
        <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
          <i class="fa fa-remove"></i>
        </a>
        <h4 class="w3-bar-item"><b>Menu</b></h4>
        <PaneLink linkText="Home" linkAddress="#"/>
        <PaneLink linkText="Feature1" linkAddress="#"/>
        <PaneLink linkText="Feature2" linkAddress="#"/>
        <PaneLink linkText="Feature3" linkAddress="#"/>
        <PaneLink linkText="Feature4" linkAddress="#"/>
        <PaneLink linkText="About Us" linkAddress="#"/>
      </nav>
    )
  }
}
class PaneLink extends Component{
  render(){
    return(
      <a className="w3-bar-item w3-button w3-hover-black" href={this.props.linkAddress}>{this.props.linkText}</a>
    )
  }
}
class MainPane extends Component{
  render(){
    return(
      <div class="w3-main" style={divStyle}>
        <div class="w3-row w3-padding-64">
        <div class="w3-twothird w3-container">
          <h1 class="w3-text-teal">Heading</h1>
          <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum
            dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        </div>
        <div class="w3-third w3-container">
          <p class="w3-border w3-padding-large w3-padding-32 w3-center">AD</p>
          <p class="w3-border w3-padding-large w3-padding-64 w3-center">AD</p>
        </div>
      </div>
    </div>

    );
  }
}
class Footer extends Component{
  render(){
    return(
      <div>
        <footer id="myFooter">
        <div class="w3-container w3-theme-l2 w3-padding-32">
        <h4>Footer</h4>
        </div>
        <div class="w3-container w3-theme-l1">
        <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
        </div>
        </footer>
      </div>
    )
  }
}
//-- Overlay effect when opening sidebar on small screens --
class OverLay extends Component{
  render(){
    return(
      <div class="w3-overlay w3-hide-large" onclick="w3_close()" title="close side menu" id="myOverlay"></div>
    )
  }
}
export default App;
