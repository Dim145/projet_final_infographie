#define PROCESSING_TEXLIGHT_SHADER

uniform mat4 modelview;
uniform mat4 transform;
uniform mat3 normalMatrix;

attribute vec4 position;
attribute vec4 color;
attribute vec3 normal;
attribute vec4 emissive;
attribute float shininess;

varying vec4 vertColor;
varying vec4 vertEmissive;
varying float vertShininess;
varying vec3 ecNormal;
varying vec3 ecPosition;

// -- new in cour 5 --

attribute vec2 texCoord; // Entrée
varying vec2 uv; // Sortie

void main()
{
    gl_Position   = transform * position;
    ecPosition    = vec3(modelview * position);
    ecNormal      = normalize(normalMatrix * normal);
    vertEmissive  = emissive;
    vertColor     = color;
    vertShininess = shininess;

    uv = texCoord; // transfert vers le fragment shader
}
