#!/bin/bash

#$ -S /bin/bash
#$ -pe mpi 4
#$ -cwd
#$ -o console.out
#$ -l h=compute-0-3.local

export CUDA_VISIBLE_DEVICES=MIG-7082f15e-b12d-504c-96e0-3b8a2aadd641


bash -i run_script.bash
