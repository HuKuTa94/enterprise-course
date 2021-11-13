#!/bin/bash
(exec "${BASH_SOURCE%/*}/clean.sh")
(exec "${BASH_SOURCE%/*}/run.sh")
