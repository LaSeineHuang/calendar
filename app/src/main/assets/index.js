const json = {
  date: '2024.03.13',
  mercury: 9, // 水
  venus: 22, // 金
  mars: 21, // 火
  jupiter: 2, // 木
  saturn: 23, // 土
}

window.document.title = json.date

const layerRadii = [60, 150, 250, 350, 450]; // 每层的内半径
const starRadius = 60
const placePoint = (xiuwei, circleRadius, elementId) => {
  const angleDegrees = - 360 / 28 * xiuwei;
  const angleRadians = angleDegrees * (Math.PI / 180);

  const x = circleRadius * Math.cos(angleRadians);
  const y = circleRadius * Math.sin(angleRadians);

  const pointElement = document.getElementById(elementId);

  pointElement.style.left = `${circleRadius + x - starRadius}px`;
  pointElement.style.top = `${circleRadius + y - starRadius}px`;
}

const layers = document.querySelectorAll('.disk-layer');
layers.forEach((layer, index) => {
  layer.style.width = `${layerRadii[index] * 2}px`;
  layer.style.height = `${layerRadii[index] * 2}px`;
});


placePoint(json.mercury, layerRadii[0], 'pointA')
placePoint(json.venus, layerRadii[1], 'pointB')
placePoint(json.mars, layerRadii[2], 'pointC')
placePoint(json.jupiter, layerRadii[3], 'pointD')
placePoint(json.saturn, layerRadii[4], 'pointE')

