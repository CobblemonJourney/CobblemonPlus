#!/bin/bash

if ! git remote | grep -q "upstream"; then
    git remote add upstream "https://gitlab.com/cable-mc/cobblemon.git"
    echo "Upstream remote added successfully."
else
    echo "Upstream remote already exists."
fi

git fetch upstream main
git merge --allow-unrelated-histories upstream/main

# Suppress errors if the directory doesn't exist
rm -rf forge