{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  buildInputs = with pkgs; [
    openjdk21
    maven
  ];

  shellHook = ''
    export JAVA_HOME=${pkgs.openjdk21}/lib/openjdk
    export M2_HOME=${pkgs.maven}/lib/maven
    export PATH=$PATH:$JAVA_HOME/bin
  '';
}
