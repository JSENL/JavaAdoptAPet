import React, { Component } from 'react';
import { Slide, Fade, Zoom } from './lib';
import './app.css';

class App extends Component {
  constructor() {
    super();
    this.state = {
      zoomOutImages: [
        'images/slide_2.jpg',
        'images/slide_7.jpg',
        'images/slide_5.jpg'
      ],
      slideImages: [
        'images/slide_2.jpg',
        'images/slide_3.jpg',
        'images/slide_4.jpg'
      ],
      fadeImages: [
        'images/slide_5.jpg',
        'images/slide_6.jpg',
        'images/slide_7.jpg'
      ]
    };
  }

  render() {
    const properties = {
      duration: 5000,
      transitionDuration: 500,
      infinite: true,
      indicators: true,
      onChange: (oldIndex, newIndex) => {
        console.log(
          `Slide transition finished from ${oldIndex} to ${newIndex}`
        );
      }
    };

    const fadeProperties = {
      duration: 5000,
      transitionDuration: 500,
      indicators: true,
      infinite: false,
      onChange: (oldIndex, newIndex) => {
        console.log(`Fade transition finished from ${oldIndex} to ${newIndex}`);
      }
    };

    const zoomOutProperties = {
      duration: 5000,
      transitionDuration: 500,
      indicators: true,
      scale: 0.4,
      onChange: (oldIndex, newIndex) => {
        console.log(`zoom transition finished from ${oldIndex} to ${newIndex}`);
      }
    };

    const zoomInProperties = {
      duration: 5000,
      transitionDuration: 500,
      indicators: true,
      scale: 1.4
    };
    const { slideImages, zoomOutImages, fadeImages } = this.state;
    return (
      <div>
        <h3>Slide Effect</h3>
        <div className="slide-container">
          <Slide {...properties}>
            {slideImages.map((each, index) => (
              <div key={index} className="each-slide">
                <div style={{ backgroundImage: `url(${each})` }}>
                  <span>Slide {index + 1}</span>
                </div>
              </div>
            ))}
          </Slide>
        </div>
        <br />

        <h3>Fade Effect</h3>
        <div className="slide-container">
          <Fade {...fadeProperties}>
            <div className="each-fade">
              <div className="image-container">
                <img src={fadeImages[0]} />
              </div>
              <h2>First Slide</h2>
            </div>
            <div className="each-fade">
              <h2>Second Slide</h2>
              <div className="image-container">
                <img src={fadeImages[1]} />
              </div>
            </div>
            <div className="each-fade">
              <div className="image-container">
                <img src={fadeImages[2]} />
              </div>
              <h2>Third Slide</h2>
            </div>
          </Fade>
        </div>

        <br />
        <h3>Zoom out Effect</h3>
        <div className="slide-container">
          <Zoom {...zoomOutProperties}>
            {zoomOutImages.map((each, index) => (
              <img key={index} style={{ width: '100%' }} src={each} />
            ))}
          </Zoom>
        </div>
        <br />
        <h3>Zoom in Effect</h3>
        <div className="slide-container">
          <Zoom {...zoomInProperties}>
            {fadeImages.map((each, index) => (
              <img key={index} style={{ width: '100%' }} src={each} />
            ))}
          </Zoom>
        </div>
        <br />
      </div>
    );
  }
}

export default App;
