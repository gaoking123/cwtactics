xof 0303txt 0032

template XSkinMeshHeader {
  <3cf169ce-ff7c-44ab-93c0-f78f62d172e2>
  WORD nMaxSkinWeightsPerVertex;
  WORD nMaxSkinWeightsPerFace;
  WORD nBones;
}

template SkinWeights {
  <6f0d123b-bad2-4167-a0d0-80224f25fabb>
  STRING transformNodeName;
  DWORD nWeights;
  array DWORD vertexIndices[nWeights];
  array float weights[nWeights];
  Matrix4x4 matrixOffset;
}

Frame Cube_003 {
  FrameTransformMatrix {
    0.000000,-0.000000,-0.500000,0.000000,
    0.000000,0.500000,-0.000000,0.000000,
    0.500000,-0.000000,0.000000,0.000000,
    -0.800000,-0.000000,-0.200000,1.000000;;
  }
  Mesh { //Cube_003 Mesh
    24;
    -0.899999;0.000000;2.600001;,
    -0.900000;0.000000;2.200001;,
    0.100000;0.000000;2.200000;,
    0.100000;0.000000;2.600000;,
    -0.000000;0.400000;2.300000;,
    -0.800000;0.400000;2.300001;,
    -0.800000;0.400000;2.500000;,
    0.000001;0.400000;2.500000;,
    0.100000;0.000000;2.200000;,
    -0.000000;0.400000;2.300000;,
    0.000001;0.400000;2.500000;,
    0.100000;0.000000;2.600000;,
    -0.900000;0.000000;2.200001;,
    -0.800000;0.400000;2.300001;,
    -0.000000;0.400000;2.300000;,
    0.100000;0.000000;2.200000;,
    -0.899999;0.000000;2.600001;,
    -0.800000;0.400000;2.500000;,
    -0.800000;0.400000;2.300001;,
    -0.900000;0.000000;2.200001;,
    -0.800000;0.400000;2.500000;,
    -0.899999;0.000000;2.600001;,
    0.100000;0.000000;2.600000;,
    0.000001;0.400000;2.500000;;
    6;
    4;0;1;2;3;,
    4;4;5;6;7;,
    4;8;9;10;11;,
    4;12;13;14;15;,
    4;16;17;18;19;,
    4;20;21;22;23;;
    MeshNormals { //Mesh Normals
      24;
      0.000000;-1.000000;0.000000;,
      0.000000;-1.000000;0.000000;,
      0.000000;-1.000000;0.000000;,
      0.000000;-1.000000;0.000000;,
      0.000000;1.000000;-0.000000;,
      0.000000;1.000000;-0.000000;,
      0.000000;1.000000;-0.000000;,
      0.000000;1.000000;-0.000000;,
      0.970142;0.242536;-0.000002;,
      0.970142;0.242536;-0.000002;,
      0.970142;0.242536;-0.000002;,
      0.970142;0.242536;-0.000002;,
      -0.000001;0.242535;-0.970143;,
      -0.000001;0.242535;-0.970143;,
      -0.000001;0.242535;-0.970143;,
      -0.000001;0.242535;-0.970143;,
      -0.970143;0.242535;0.000001;,
      -0.970143;0.242535;0.000001;,
      -0.970143;0.242535;0.000001;,
      -0.970143;0.242535;0.000001;,
      0.000001;0.242537;0.970142;,
      0.000001;0.242537;0.970142;,
      0.000001;0.242537;0.970142;,
      0.000001;0.242537;0.970142;;
      6;
      4;0;1;2;3;,
      4;4;5;6;7;,
      4;8;9;10;11;,
      4;12;13;14;15;,
      4;16;17;18;19;,
      4;20;21;22;23;;
    } //End of Mesh Normals
    MeshMaterialList { //Mesh Material List
      1;
      6;
      0,
      0,
      0,
      0,
      0,
      0;;
      Material Material {
        0.800000;0.800000;0.800000;1.000000;;
        1.500000;
        1.000000;1.000000;1.000000;;
        0.000000;0.000000;0.000000;;
        TextureFilename {"Cursor.png";}
      }
    } //End of Mesh Material List
    MeshTextureCoords { //Mesh UV Coordinates
      24;
      0.000000;0.421165;,
      0.000000;0.140389;,
      0.701940;0.140389;,
      0.701940;0.421165;,
      0.561552;0.140389;,
      0.000000;0.140388;,
      0.000000;0.000000;,
      0.561553;0.000000;,
      0.701940;0.710582;,
      0.770156;0.429319;,
      0.906589;0.429319;,
      0.974806;0.710582;,
      0.000000;0.710582;,
      0.070194;0.421165;,
      0.631746;0.421165;,
      0.701940;0.710582;,
      0.982716;0.710583;,
      0.912522;1.000000;,
      0.772134;1.000000;,
      0.701940;0.710583;,
      0.070194;1.000000;,
      0.000000;0.710582;,
      0.701940;0.710583;,
      0.631746;1.000000;;
    } //End of Mesh UV Coordinates
  } //End of Cube_003 Mesh
} //End of Cube_003
Frame Cube_002 {
  FrameTransformMatrix {
    -0.000000,0.000000,0.500000,0.000000,
    -0.000000,0.500000,-0.000000,0.000000,
    -0.500000,-0.000000,-0.000000,0.000000,
    -0.800000,-0.000000,-0.200000,1.000000;;
  }
  Mesh { //Cube_002 Mesh
    24;
    -0.100000;-0.000000;-0.600000;,
    -0.100000;-0.000000;-1.000000;,
    0.900000;-0.000000;-1.000000;,
    0.900000;-0.000000;-0.600000;,
    0.799999;0.400000;-0.900001;,
    -0.000000;0.400000;-0.900000;,
    0.000000;0.400000;-0.700000;,
    0.800001;0.400000;-0.700001;,
    0.900000;-0.000000;-1.000000;,
    0.799999;0.400000;-0.900001;,
    0.800001;0.400000;-0.700001;,
    0.900000;-0.000000;-0.600000;,
    -0.100000;-0.000000;-1.000000;,
    -0.000000;0.400000;-0.900000;,
    0.799999;0.400000;-0.900001;,
    0.900000;-0.000000;-1.000000;,
    -0.100000;-0.000000;-0.600000;,
    0.000000;0.400000;-0.700000;,
    -0.000000;0.400000;-0.900000;,
    -0.100000;-0.000000;-1.000000;,
    0.000000;0.400000;-0.700000;,
    -0.100000;-0.000000;-0.600000;,
    0.900000;-0.000000;-0.600000;,
    0.800001;0.400000;-0.700001;;
    6;
    4;0;1;2;3;,
    4;4;5;6;7;,
    4;8;9;10;11;,
    4;12;13;14;15;,
    4;16;17;18;19;,
    4;20;21;22;23;;
    MeshNormals { //Mesh Normals
      24;
      0.000000;-1.000000;0.000000;,
      0.000000;-1.000000;0.000000;,
      0.000000;-1.000000;0.000000;,
      0.000000;-1.000000;0.000000;,
      0.000000;1.000000;-0.000000;,
      0.000000;1.000000;-0.000000;,
      0.000000;1.000000;-0.000000;,
      0.000000;1.000000;-0.000000;,
      0.970142;0.242536;-0.000002;,
      0.970142;0.242536;-0.000002;,
      0.970142;0.242536;-0.000002;,
      0.970142;0.242536;-0.000002;,
      -0.000001;0.242535;-0.970143;,
      -0.000001;0.242535;-0.970143;,
      -0.000001;0.242535;-0.970143;,
      -0.000001;0.242535;-0.970143;,
      -0.970143;0.242535;0.000001;,
      -0.970143;0.242535;0.000001;,
      -0.970143;0.242535;0.000001;,
      -0.970143;0.242535;0.000001;,
      0.000001;0.242537;0.970142;,
      0.000001;0.242537;0.970142;,
      0.000001;0.242537;0.970142;,
      0.000001;0.242537;0.970142;;
      6;
      4;0;1;2;3;,
      4;4;5;6;7;,
      4;8;9;10;11;,
      4;12;13;14;15;,
      4;16;17;18;19;,
      4;20;21;22;23;;
    } //End of Mesh Normals
    MeshMaterialList { //Mesh Material List
      1;
      6;
      0,
      0,
      0,
      0,
      0,
      0;;
      Material Material {
        0.800000;0.800000;0.800000;1.000000;;
        1.500000;
        1.000000;1.000000;1.000000;;
        0.000000;0.000000;0.000000;;
        TextureFilename {"Cursor.png";}
      }
    } //End of Mesh Material List
    MeshTextureCoords { //Mesh UV Coordinates
      24;
      0.000000;0.421165;,
      0.000000;0.140389;,
      0.701940;0.140389;,
      0.701940;0.421165;,
      0.561552;0.140389;,
      0.000000;0.140388;,
      0.000000;0.000000;,
      0.561553;0.000000;,
      0.701940;0.710582;,
      0.770156;0.429319;,
      0.906589;0.429319;,
      0.974806;0.710582;,
      0.000000;0.710582;,
      0.070194;0.421165;,
      0.631746;0.421165;,
      0.701940;0.710582;,
      0.982716;0.710583;,
      0.912522;1.000000;,
      0.772134;1.000000;,
      0.701940;0.710583;,
      0.070194;1.000000;,
      0.000000;0.710582;,
      0.701940;0.710583;,
      0.631746;1.000000;;
    } //End of Mesh UV Coordinates
  } //End of Cube_002 Mesh
} //End of Cube_002
Frame Cube_001 {
  FrameTransformMatrix {
    -0.500000,-0.000000,-0.000000,0.000000,
    0.000000,0.500000,-0.000000,0.000000,
    0.000000,-0.000000,-0.500000,0.000000,
    0.000000,-0.000000,-0.800000,1.000000;;
  }
  Mesh { //Cube_001 Mesh
    24;
    -0.500000;-0.000000;-0.600000;,
    -0.500000;-0.000000;-1.000000;,
    0.500000;-0.000000;-1.000000;,
    0.500000;-0.000000;-0.600000;,
    0.399999;0.400000;-0.900001;,
    -0.400000;0.400000;-0.900000;,
    -0.400000;0.400000;-0.700000;,
    0.400000;0.400000;-0.700001;,
    0.500000;-0.000000;-1.000000;,
    0.399999;0.400000;-0.900001;,
    0.400000;0.400000;-0.700001;,
    0.500000;-0.000000;-0.600000;,
    -0.500000;-0.000000;-1.000000;,
    -0.400000;0.400000;-0.900000;,
    0.399999;0.400000;-0.900001;,
    0.500000;-0.000000;-1.000000;,
    -0.500000;-0.000000;-0.600000;,
    -0.400000;0.400000;-0.700000;,
    -0.400000;0.400000;-0.900000;,
    -0.500000;-0.000000;-1.000000;,
    -0.400000;0.400000;-0.700000;,
    -0.500000;-0.000000;-0.600000;,
    0.500000;-0.000000;-0.600000;,
    0.400000;0.400000;-0.700001;;
    6;
    4;0;1;2;3;,
    4;4;5;6;7;,
    4;8;9;10;11;,
    4;12;13;14;15;,
    4;16;17;18;19;,
    4;20;21;22;23;;
    MeshNormals { //Mesh Normals
      24;
      0.000000;-1.000000;0.000000;,
      0.000000;-1.000000;0.000000;,
      0.000000;-1.000000;0.000000;,
      0.000000;-1.000000;0.000000;,
      0.000000;1.000000;-0.000000;,
      0.000000;1.000000;-0.000000;,
      0.000000;1.000000;-0.000000;,
      0.000000;1.000000;-0.000000;,
      0.970142;0.242536;-0.000002;,
      0.970142;0.242536;-0.000002;,
      0.970142;0.242536;-0.000002;,
      0.970142;0.242536;-0.000002;,
      -0.000001;0.242535;-0.970143;,
      -0.000001;0.242535;-0.970143;,
      -0.000001;0.242535;-0.970143;,
      -0.000001;0.242535;-0.970143;,
      -0.970143;0.242535;0.000001;,
      -0.970143;0.242535;0.000001;,
      -0.970143;0.242535;0.000001;,
      -0.970143;0.242535;0.000001;,
      0.000001;0.242537;0.970142;,
      0.000001;0.242537;0.970142;,
      0.000001;0.242537;0.970142;,
      0.000001;0.242537;0.970142;;
      6;
      4;0;1;2;3;,
      4;4;5;6;7;,
      4;8;9;10;11;,
      4;12;13;14;15;,
      4;16;17;18;19;,
      4;20;21;22;23;;
    } //End of Mesh Normals
    MeshMaterialList { //Mesh Material List
      1;
      6;
      0,
      0,
      0,
      0,
      0,
      0;;
      Material Material {
        0.800000;0.800000;0.800000;1.000000;;
        1.500000;
        1.000000;1.000000;1.000000;;
        0.000000;0.000000;0.000000;;
        TextureFilename {"Cursor.png";}
      }
    } //End of Mesh Material List
    MeshTextureCoords { //Mesh UV Coordinates
      24;
      0.000000;0.421165;,
      0.000000;0.140389;,
      0.701940;0.140389;,
      0.701940;0.421165;,
      0.561552;0.140389;,
      0.000000;0.140388;,
      0.000000;0.000000;,
      0.561553;0.000000;,
      0.701940;0.710582;,
      0.770156;0.429319;,
      0.906589;0.429319;,
      0.974806;0.710582;,
      0.000000;0.710582;,
      0.070194;0.421165;,
      0.631746;0.421165;,
      0.701940;0.710582;,
      0.982716;0.710583;,
      0.912522;1.000000;,
      0.772134;1.000000;,
      0.701940;0.710583;,
      0.070194;1.000000;,
      0.000000;0.710582;,
      0.701940;0.710583;,
      0.631746;1.000000;;
    } //End of Mesh UV Coordinates
  } //End of Cube_001 Mesh
} //End of Cube_001
Frame Cube {
  FrameTransformMatrix {
    0.500000,0.000000,0.000000,0.000000,
    0.000000,0.500000,0.000000,0.000000,
    0.000000,0.000000,0.500000,0.000000,
    0.000000,0.000000,0.800000,1.000000;;
  }
  Mesh { //Cube Mesh
    24;
    -0.500000;-0.000000;-0.600000;,
    -0.500000;-0.000000;-1.000000;,
    0.500000;-0.000000;-1.000000;,
    0.500000;-0.000000;-0.600000;,
    0.399999;0.400000;-0.900001;,
    -0.400000;0.400000;-0.900000;,
    -0.400000;0.400000;-0.700000;,
    0.400000;0.400000;-0.700001;,
    0.500000;-0.000000;-1.000000;,
    0.399999;0.400000;-0.900001;,
    0.400000;0.400000;-0.700001;,
    0.500000;-0.000000;-0.600000;,
    -0.500000;-0.000000;-1.000000;,
    -0.400000;0.400000;-0.900000;,
    0.399999;0.400000;-0.900001;,
    0.500000;-0.000000;-1.000000;,
    -0.500000;-0.000000;-0.600000;,
    -0.400000;0.400000;-0.700000;,
    -0.400000;0.400000;-0.900000;,
    -0.500000;-0.000000;-1.000000;,
    -0.400000;0.400000;-0.700000;,
    -0.500000;-0.000000;-0.600000;,
    0.500000;-0.000000;-0.600000;,
    0.400000;0.400000;-0.700001;;
    6;
    4;0;1;2;3;,
    4;4;5;6;7;,
    4;8;9;10;11;,
    4;12;13;14;15;,
    4;16;17;18;19;,
    4;20;21;22;23;;
    MeshNormals { //Mesh Normals
      24;
      0.000000;-1.000000;0.000000;,
      0.000000;-1.000000;0.000000;,
      0.000000;-1.000000;0.000000;,
      0.000000;-1.000000;0.000000;,
      0.000000;1.000000;-0.000000;,
      0.000000;1.000000;-0.000000;,
      0.000000;1.000000;-0.000000;,
      0.000000;1.000000;-0.000000;,
      0.970142;0.242536;-0.000002;,
      0.970142;0.242536;-0.000002;,
      0.970142;0.242536;-0.000002;,
      0.970142;0.242536;-0.000002;,
      -0.000001;0.242535;-0.970143;,
      -0.000001;0.242535;-0.970143;,
      -0.000001;0.242535;-0.970143;,
      -0.000001;0.242535;-0.970143;,
      -0.970143;0.242535;0.000001;,
      -0.970143;0.242535;0.000001;,
      -0.970143;0.242535;0.000001;,
      -0.970143;0.242535;0.000001;,
      0.000001;0.242537;0.970142;,
      0.000001;0.242537;0.970142;,
      0.000001;0.242537;0.970142;,
      0.000001;0.242537;0.970142;;
      6;
      4;0;1;2;3;,
      4;4;5;6;7;,
      4;8;9;10;11;,
      4;12;13;14;15;,
      4;16;17;18;19;,
      4;20;21;22;23;;
    } //End of Mesh Normals
    MeshMaterialList { //Mesh Material List
      1;
      6;
      0,
      0,
      0,
      0,
      0,
      0;;
      Material Material {
        0.800000;0.800000;0.800000;1.000000;;
        1.500000;
        1.000000;1.000000;1.000000;;
        0.000000;0.000000;0.000000;;
        TextureFilename {"Cursor.png";}
      }
    } //End of Mesh Material List
    MeshTextureCoords { //Mesh UV Coordinates
      24;
      0.000000;0.421165;,
      0.000000;0.140389;,
      0.701940;0.140389;,
      0.701940;0.421165;,
      0.561552;0.140389;,
      0.000000;0.140388;,
      0.000000;0.000000;,
      0.561553;0.000000;,
      0.701940;0.710582;,
      0.770156;0.429319;,
      0.906589;0.429319;,
      0.974806;0.710582;,
      0.000000;0.710582;,
      0.070194;0.421165;,
      0.631746;0.421165;,
      0.701940;0.710582;,
      0.982716;0.710583;,
      0.912522;1.000000;,
      0.772134;1.000000;,
      0.701940;0.710583;,
      0.070194;1.000000;,
      0.000000;0.710582;,
      0.701940;0.710583;,
      0.631746;1.000000;;
    } //End of Mesh UV Coordinates
  } //End of Cube Mesh
} //End of Cube
AnimationSet {
} //End of AnimationSet
